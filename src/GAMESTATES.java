public class GAMESTATES {

    private static boolean isPlay = true;
    private static boolean isPause = false;
    private static boolean isMenu = false;
    private static boolean isEnd = false;

    //setters and getters
    public static boolean isPlay(){
        return isPlay;
    }
    public static boolean isPause() {
        return isPause;
    }
    public static void startPlay(){
        isPlay = true;
    }
}
