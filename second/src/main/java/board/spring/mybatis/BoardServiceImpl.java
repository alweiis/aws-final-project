package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;
	
	@Override
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}

	@Override
	public List<BoardDTO> getBoardList(int limit) {
		return dao.getBoardList(limit);
	}

	@Override
	public BoardDTO getOneBoard(int seq) {
		dao.updateViewCount(seq);
		return dao.getOneBoard(seq);
	}	// 조회수를 1증가시키고, 게시글 조회

}
