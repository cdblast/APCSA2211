import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.*;

public class DataCollector
{
  private ArrayList<String> socialMediaPosts;
  private ArrayList<String> targetWords;
  private Scanner sc;
  private int currentPost;
  private int currentTargetWord;

  public DataCollector()
  {
    socialMediaPosts = new ArrayList<String>();
    targetWords = new ArrayList<String>();
    currentPost = 0;
    currentTargetWord = 0;
  }

  public void setData(String socialMediaPostsFilename, String targetWordsFilename) {
    try
    {
      sc = new Scanner(new File(socialMediaPostsFilename));
      while (sc.hasNextLine())
      {
        String temp = sc.nextLine().trim();
        this.socialMediaPosts.add(temp);
      }
    } catch (Exception e) { System.out.println("Error reading or parsing" + socialMediaPosts + "\n" + e); }

    try
    {
      sc = new Scanner(new File(targetWordsFilename));
      while (sc.hasNextLine())
      {
        this.targetWords.add(sc.nextLine().trim());
      }
    } catch (Exception e) { System.out.println("Error reading or parsing" + targetWords + "\n" + e); }
  }

  public String getNextPost()
  {
    if (currentPost < socialMediaPosts.size())
    {
      this.currentPost++;
      return socialMediaPosts.get(currentPost - 1);
    }
    else
    {
      return "NONE";
    }
  }

  public String getNextTargetWord()
  {
    if (currentTargetWord < targetWords.size())
    {
      this.currentTargetWord++;
      return targetWords.get(currentTargetWord - 1);
    }
    else
    {
      this.currentTargetWord = 0;
      return "NONE";
    }
  }

  public void prepareAdvertisement(String filename, String usernames, String advertisement)
  {
    try
    {
      FileWriter fw = new FileWriter(filename);
      for (String un : usernames.split(" "))
      {
          fw.write("@" + un + " " + advertisement + "\n");
      }
      fw.close();
    }
    catch (IOException e)
    {
        System.out.println("Could not write to file. " + e);
    }
  }
}