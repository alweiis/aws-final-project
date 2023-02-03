package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	BoardDTO getOneBoard(int seq);
}
