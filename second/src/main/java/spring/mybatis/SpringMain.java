package spring.mybatis;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
		/*
		String[] names = factory.getBeanDefinitionNames();
		System.out.println("========================================");
		for(String n: names) {
			System.out.println(n);
		}
		System.out.println("========================================");
		*/
		
		MemberService service = (MemberService) factory.getBean("service");
		
		// test1 - 회원 목록 조회
		List<MemberDTO> list = service.memberlist();
		for(MemberDTO m : list) {
			System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName());
		}
		
		// test2 - 회원 수 조회
		//System.out.println("전체 회원 수 = " + service.membercount());
		
		// test3 - 특정 회원 조회(입력 파라미터 존재, 결과 MemberDTO)
//		MemberDTO m = service.oneMember("abc0");
//		if (m != null) {
//			System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName());			
//		}
		
		// test4 - 페이징처리 리스트 조회
//		int[] limit = {0, 3};
//		List<MemberDTO> list = service.paginglist(limit);
//		for(MemberDTO m : list) {
//			System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName());
//		}
		
		// test5 - 회원 정보 저장
		
//		MemberDTO insertdto = new MemberDTO();
//		insertdto.setId("mybatis");
//		insertdto.setPw("mybatis");
//		insertdto.setName("김디비");
//		insertdto.setPhone("01012526985");
//		insertdto.setEmail("batis@sba.com");
//		insertdto.setAddress("서울시 금천구");
//		service.insertmember(insertdto);
		
		// test6 - 회원 정보 수정
//		MemberDTO updatedto = new MemberDTO();
//		updatedto.setId("mybatis");
//		updatedto.setName("박한국");
//		updatedto.setPhone("01087654321");
//		updatedto.setEmail("mybqatis@b.com");
//		service.updatemember(updatedto);
		
		
		// test7 - 회원 정보 삭제
		// id가 mybatis인 회원 정보 삭제
//		service.deletemember("mybatis");
		
		
		// test8
//		HashMap<String, String> map = new HashMap<>();
//		map.put("colname", "indate");
//		map.put("colvalue", "%2023%");
//		List<MemberDTO> list = service.searchmember(map);
//		for(MemberDTO m : list) {
//			System.out.println(m.getId() + " : " + m.getPw() + " : " + m.getName());
//		}
		
		
		// test9 - 주소로 회원 정보 조회
//		ArrayList<String> addresslist = new ArrayList<>();
//		addresslist.add("서울시 용산구");
//		addresslist.add("서울시 관악구");
//		addresslist.add("서울시 동작구");
//		List<MemberDTO> list = service.addresssearch(addresslist);
//		for(MemberDTO m : list) {
//			System.out.println(m.getId() + " : " + m.getName() + " : " +  m.getAddress());
//		}
		
		// test10 - 조합 + 동적 조건절
//		MemberDTO dto = new MemberDTO();
//		dto.setName("김프링");
//		dto.setEmail("mybqatis@b.com");
//		List<MemberDTO> list = service.combination(dto);
//		for(MemberDTO m : list) {
//			System.out.println(m.getId() + " : " + m.getName() + " : " +  m.getAddress());
//		}
		
		// test11
		/*
		List<HashMap<String, String>> list = service.memberboard("mybatis");
		for (HashMap<String, String> map: list) {
			Set<String> keys = map.keySet();
			for (String s: keys) {
				System.out.println(s + " : " + map.get(s));
			}
			System.out.println();
		}
		*/
		
		// example
		/*
		System.out.println("회원 탈퇴를 진행합니다.");
		System.out.print("탈퇴할 회원 id를 입력해주세요: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		
		System.out.println("사용자 탈퇴 전에 작성하신 글도 삭제하시겠습니까?");
		*/
		
	}

}
