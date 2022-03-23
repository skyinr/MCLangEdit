package skyinr.github.unit;

public class IsLang {
    private IsLang(){

    }
    public static boolean isLang(String lang){
        return lang.equals(".lang")||lang.equals(".json");
    }

    public static String filterLang(String lang){
        if(isLang(lang)){
            return lang.substring(5);
        }
        return lang;
    }
}
