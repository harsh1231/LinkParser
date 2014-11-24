package parser;


public class  RegexTestStrings{
	
	public  static boolean isValidSyntax(String link) {
	       
        
       
        // regex for ptokenchar
        String pTokenChar="[-a-zA-Z0-9|!#@$%&`*()/[/]{}=<>~'./?_]+";
      
        // Regex for strings
        String string= "[^\"=]+";
        String p="(.*)" + "application/link-format[+]json" + "(.*)";
        System.out.println(link.matches(p));
        // Regex for quoted strings
        String quotedString= "\"" + string + "\"";
       
        // Regex for Location
        String location= "(" + "/" + string + ")" + "+";
      
        // Regex for url
        String url= "[-a-zA-Z0-9]+:(//)?[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
       
        // Regex for resource
        // resource => < url | loc > ( ; string = ( (ptokenchar)+ | quotedstring  ) )*
        String resource= "\\s*<\\s*" + "(" + url + "|" + location + ")" + "\\s*>\\s*" + "(" + "\\s*;\\s*" + string +
                         "\\s*=\\s*" + "("+ pTokenChar + "|" + quotedString + ")" + ")" + "*";
      
        // Regex for resourceList
        // resourceList => resource ( ,resource) *
        String resourceList= resource + "(" + "\\s*,\\s*" + resource + ")" + "*"; 

        if (link.matches(resourceList)) {
            return true;
        }
        return false;
    }

    
    public static void main (String args[]){
	String link="       application/link-format+json; charset=UTF-8     ";
	System.out.println(RegexTestStrings.isValidSyntax(link));
    }

} 