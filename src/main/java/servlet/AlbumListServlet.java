package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import model.Album;

@WebServlet("/albums")
public class AlbumListServlet extends HttpServlet{
	
	private AlbumDao dao = new AlbumDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String stringId = req.getParameter("ArtistId");
		 long parsedId = Long.parseLong(stringId);
		 List<Album> allAlbums= this.dao.getAllAlbums(parsedId);
	
		 req.setAttribute("albums", allAlbums);
		 req.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(req, resp);
		}
	
	}
