public class TargetedAd {

  public static void main(String[] args)
  {
    DataCollector dc = new DataCollector();
    dc.setData("socialMediaPostsSmall.txt", "targetWords.txt");

    String users = "";

    String post = dc.getNextPost();

    while (!post.equals("NONE")) {

      String username = post.substring(0, post.indexOf(" "));
      String lowerPost = post.toLowerCase();

      String target = dc.getNextTargetWord();

      while (!target.equals("NONE")) {

        if (lowerPost.indexOf(target) != -1) {

          users += username + " ";
        }

        target = dc.getNextTargetWord();
      }

      post = dc.getNextPost();
    }

    dc.prepareAdvertisement(
      "targetedAds.txt",
      users,
      "Your furry friend will love our pet food!"
    );

    System.out.println("Finished (but not perfect)");
  }
}