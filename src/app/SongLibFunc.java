package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SongLibFunc 
{
	public static LinkedList<Song> songList = new LinkedList<>();
	
 	public static Song getSong(String songName, String artist)
	{
		for (Song song : songList) 
		{
			//if song == s; if s exists in the song lib
			if(compare(song, new Song(songName, artist, "", "")) == 0)
				return song;
		}
		return null;
	}
 	
 	public static int getIndex(String songName, String artist)
 	{
 		int i = -1;
 		for (Song song : songList) 
		{
 			i++;
			//if song == s; if s exists in the song lib
			if(compare(song, new Song(songName, artist, "", "")) == 0)
				return i;
		}
 		
 		return -1;
 	}
	
	private static int compare(Song s1, Song s2)
	{
		String str1 = s1.getSong() + "  " + s1.getArtist();
		String str2 = s2.getSong() + "  " + s2.getArtist();

		return (str1.compareToIgnoreCase(str2));
	}
	
	//returns false if the same song and artist exits in the song lib.
	public static boolean add(String song, String artist, String year, String album)
	{
		Song s = new Song(song, artist, year, album);
		
		if(songList.isEmpty())
			songList.add(s);
		
		//if the song lib is not empty 
		else
		{	
			ListIterator<Song> itr = songList.listIterator();
			while(itr.hasNext())
			{
				Song curr = itr.next();
				
				int comparison = compare(curr, s);
				
				//curr(song+artist) > s(song+artist)
				if(comparison > 0)
				{
					itr.previous();
					itr.add(s);					
					return true;
				}
				
				//curr(song+artist) == s(song+artist)
				else if(comparison == 0)
					return false;
			}
			itr.add(s);
		}
		return true;
	}
	
	//old and new song data is NOT same. Should be checked before calling for edit().
	//This method will not check for the same data entered for the new song as the old song.
	public static boolean edit(String oldSong, String oldArtist,
			String newSong, String newArtist, String newYear, String newAlbum)
	{
				
		if(remove(oldSong, oldArtist))
		{
			return(add(newSong, newArtist, newYear, newAlbum));
		}
		
		return false;
	}

	public static boolean remove(String songName, String artist)
	{
		Song s = getSong(songName, artist);
		if(s == null)
			return false;
		else
		{
			songList.remove(s);
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void printList() throws FileNotFoundException
	{
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		
		for (Song song : songList) 
		{
			JSONObject s = new JSONObject();
			s.put("song", song.getSong());
			s.put("artist", song.getArtist());
			s.put("year", song.getYear());
			s.put("album", song.getAlbum());
			arr.add(s);
		}
		
		obj.put("songs", arr);
		
		PrintWriter write = new PrintWriter("outFile.json");
		write.append(' ');
		write.append(obj.toString());
		write.close();
		System.out.println(obj.toString());
		
	}

	public static void readNLoad() throws IOException, ParseException
	{
		File dataFile = new File("outFile.json");
		dataFile.createNewFile();
		
		FileReader read = new FileReader(dataFile);
		
		if(read.read() > 0)
		{
			JSONObject obj = (JSONObject) ((new JSONParser()).parse(read));

			JSONArray arr = (JSONArray) obj.get("songs");
			Iterator<JSONObject> i = arr.iterator();

			while (i.hasNext()) 
			{
				JSONObject s = i.next();
				add((String) s.get("song"), (String) s.get("artist"), (String) s.get("year"), (String) s.get("album"));
			}

		}
		read.close();
	}
	
}
