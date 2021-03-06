package co.yedam.project2.menu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.project2.common.Command;

public class Menu implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sum = (String) request.getSession().getAttribute("price");
		request.setAttribute("sum", sum);
		
		MenuDAO dao = new MenuDAO();
		MenuVO vo = new MenuVO();
		 vo.setFileName(request.getParameter("fileName"));
		
		List<MenuVO> list = dao.getList();
		
		
		
		request.setAttribute("menuList", list);
		return "menu/menu.jsp";
	}

}
