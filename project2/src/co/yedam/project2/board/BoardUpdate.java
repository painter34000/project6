package co.yedam.project2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class BoardUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContents(contents);
		
		dao.boardUpdate(vo);
		
		return "BoardList.do";
	}

}