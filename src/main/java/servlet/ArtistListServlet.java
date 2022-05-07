package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ArtistDao;
import model.Artist;

@WebServlet("/")
public class ArtistListServlet extends HttpServlet{
	
	private ArtistDao dao = new ArtistDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> allArtists = this.dao.getAllArtists();
		req.setAttribute("artists", allArtists);
		req.getRequestDispatcher("/WEB-INF/artistList.jsp").forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String artistName= req.getParameter("artistName");
		Artist newArtist= new Artist(artistName);
		dao.addArtist(newArtist);
		resp.sendRedirect("/");
	}

}
