package co.yedam.project2.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;
import co.yedam.project2.member.MemberVO;



public class BoardDAO extends DAO {
	private	PreparedStatement psmt;
	private	ResultSet rs;
	
	private final String BOARD_SELECT_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	private final String BOARD_SELECT = "SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_INSERT = "INSERT INTO BOARD"
							+ "VALUES(board_seq.nextval,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?,CONTENTS=?,"
			+"REGDT=?, ID=?, FILENAME=? WHERE SEQ=?";
	private final String BOARD_DELETE = "DELECT FROM BOARD WHERE SEQ=?";
	
	public BoardDAO() {
		super();
	}
	
	
	public List<BoardVO> getSelectList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			psmt = conn.prepareStatement(BOARD_SELECT_LIST);
			rs = psmt.executeQuery();
			while(rs.next()){
				BoardVO boardvo = new BoardVO();
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegDt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setStar(rs.getString("star"));
				boardvo.setRecommand(rs.getInt("recommand"));
				list.add(boardvo);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardVO getSelect(BoardVO boardvo) {
		try {
			psmt = conn.prepareStatement(BOARD_SELECT);
			rs = psmt.executeQuery();
			if(rs.next()) {
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegDt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setStar(rs.getString("star"));
				boardvo.setRecommand(rs.getInt("recommand"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return boardvo;
	}
	
	
		public BoardVO getInsert(BoardVO boardvo) {
			try {
				psmt = conn.prepareStatement(BOARD_INSERT);
				rs = psmt.executeQuery();
				if(rs.next()) {
					boardvo.setSeq(rs.getInt("seq"));
					boardvo.setTitle(rs.getString("title"));
					boardvo.setContents(rs.getString("contents"));
					boardvo.setRegDt(rs.getString("regdt"));
					boardvo.setId(rs.getString("id"));
					boardvo.setStar(rs.getString("star"));
					boardvo.setRecommand(rs.getInt("recommand"));
				}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return boardvo;
			
		
	}

		public BoardVO getUpdate(BoardVO boardvo) {
			try {
			psmt = conn.prepareStatement(BOARD_UPDATE);
			psmt.setInt(1, boardvo.getSeq());
			rs = psmt.executeQuery();
			if(rs.next()) {
				boardvo.setSeq(rs.getInt("seq"));
				boardvo.setTitle(rs.getString("title"));
				boardvo.setContents(rs.getString("contents"));
				boardvo.setRegDt(rs.getString("regdt"));
				boardvo.setId(rs.getString("id"));
				boardvo.setStar(rs.getString("star"));
				boardvo.setRecommand(rs.getInt("recommand"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boardvo;	
	}

	public BoardVO boardDelete(BoardVO boardvo) {
		try {
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setInt(1,boardvo.getSeq());
			rs = psmt.executeQuery();
			if(rs.next()) {
				boardvo.setSeq(rs.getInt("seq"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boardvo;
	}

}