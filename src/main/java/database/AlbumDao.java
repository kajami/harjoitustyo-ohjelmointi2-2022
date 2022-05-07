package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

public class AlbumDao {
	
    private final Database db = new Database();
	
	public List<Album> getAllAlbums(long id){
		 	Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet results = null;
	
	        List<Album> albums = new ArrayList<>();
	
	        try {
	            connection = this.db.connect();
	            
	            statement = connection.prepareStatement("SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?");
	            statement.setLong(1, id);
	            results = statement.executeQuery();
	
	            while (results.next()) {
	                long AlbumId = results.getLong("AlbumId");
	                String title = results.getString("Title");
	
	                Album newAlbum = new Album(AlbumId, title);
	
	                albums.add(newAlbum);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            this.db.close(connection, statement, results);
	        }
	        return albums;
	    }

}
