package spring.mybatis;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	@RequestMapping("/")
	public String start() {
		return "mybatis/start";
	}
	
	@GetMapping("/login")
	public String login() {
		return "mybatis/loginform";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, HttpSession session) {
		MemberDTO dto = service.onemember(id);
		String view = "";
		if (dto == null) {
			view = "mybatis/memberinsert";
		} else {
			if(pw.equals(dto.getPw())) {	// 정상 로그인
				session.setAttribute("loginid", id);
				view = "mybatis/start";
			} else {						// 암호가 다름
				view = "mybatis/loginform";
			}
		}
		return view;
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("loginid") != null) {
			session.removeAttribute("loginid");
		}
		return "mybatis/start";
	}
	// 회원탈퇴
	@GetMapping("/memberdelete")
	public ModelAndView memberdelete(HttpSession session) {
		String updateresult = "";
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("loginid") != null) {
			int row = service.deletemember((String) session.getAttribute("loginid"));
			if (row == 1) {
				updateresult = "회원탈퇴정상처리";
			} else {
				updateresult = "회원탈퇴오류발생";
			}
		}
		mv.addObject("updateresult", updateresult);
		mv.setViewName("mybatis/start");
		return mv;
	}
	
	@RequestMapping("/memberinform")
	public ModelAndView memberinform(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("loginid") != null) {
			String id = (String) session.getAttribute("loginid");
			MemberDTO dto = service.onemember(id);
			mv.addObject("member", dto);
			mv.setViewName("mybatis/memberinform");
			return mv;
		} else {
			mv.setViewName("mybatis/loginform");
		}
		return mv;
	}
	
	@PostMapping("/memberupdate")
	public ModelAndView memberupdate(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		int row = service.updatemember2(dto);
		String updateresult = "";
		if (row == 1) {
			updateresult = "회원정보수정완료";
		} else {
			updateresult = "회원정보수정오류발생";
		}
		mv.addObject("updateresult", updateresult);
		mv.setViewName("mybatis/start");
		return mv;
	}
	
	@RequestMapping("/mybatismemberlist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@GetMapping("/memberinsert")
	public String memberinsert() {
		return "mybatis/memberinsert";
	}
	
	@PostMapping("/memberinsert")
	public ModelAndView memberinsert(MemberDTO dto) throws IOException {
		// 파일 업로드 c:upload 저장처리
		// dto의 image 변수에 c:upload 저장한 파일명 세팅
		System.out.println(dto);
		MultipartFile imagefile = dto.getImagefile();
		String savePath = "c:/upload/";
		String filename = imagefile.getOriginalFilename();
		String beforeext = filename.substring(0, filename.lastIndexOf('.'));
		String ext = filename.substring(filename.lastIndexOf('.'));
		String newfilename = beforeext + "(" + UUID.randomUUID().toString() + ")" + ext;
		File serverfile = new File(savePath + newfilename);
		imagefile.transferTo(serverfile);
		dto.setImage(newfilename);
		
		MemberDTO db_dto = service.onemember(dto.getId());
		String insertresult = "";
		if (db_dto == null) {
			int row = service.insertmember(dto);
			if (row == 1) {
				insertresult = "정상회원가입처리";
			} else {
				insertresult = "회원가입처리오류발생";
			}
		} else {
			insertresult = "이미 사용중인 아이디입니다.";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", insertresult);
		mv.setViewName("mybatis/memberinsert2");
		return mv;
	}
	
	@GetMapping("/memberinsert2")
	public String memberinsertresult() {
		return "mybatis/memberinsert2";
	}
	
	/*
	@GetMapping("/othermemberinform")
	public ModelAndView othermemberinform(String id, HttpSession session) {
		
//		1. 로그인 되었는지 확인
//		2-1. 로그인 안되었으면 start.jsp로 이동
//		2-2. 로그인 아이디가 "admin"인지 확인하여
//			2-2-1. 맞다면 아래 코드 수행
//			2-2-2. 아니라면 alert("회원 정보를 볼 권한이 없습니다.)
		 
		String result = null;
		String viewname = "mybatis/start";
		MemberDTO dto = null;
		if (session.getAttribute("loginid") == null) {
			result = "로그인을 먼저 진행해주세요.";
		} else {
			String loginid = (String) session.getAttribute("loginid");
			if (!loginid.equalsIgnoreCase("admin")) {
				result = "회원정보를 볼 권한이 없습니다.";
			} else {
				dto = service.onemember(id);
				viewname = "mybatis/othermemberinform";
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("updateresult", result);
		mv.addObject("otherinform", dto);
		mv.setViewName(viewname);
		return mv;
	}
	*/

	@ResponseBody
	@GetMapping("/othermemberinform")
	public MemberDTO othermemberinform(HttpSession session , String id){
		MemberDTO dto = new MemberDTO();
		String model = null;
		if(session.getAttribute("loginid") == null) {
			model =  "로그인이전입니다.";
			dto.setId(model);
		}
		else {
			String loginid = (String)session.getAttribute("loginid");
			if(!loginid.equalsIgnoreCase("admin")) {
				model = "회원정보 볼 권한 없습니다";
				dto.setId(model);
			}
			else {
				dto = service.onemember(id);
			}
		}
		return dto;
	}
}
