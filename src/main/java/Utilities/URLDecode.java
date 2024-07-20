package Utilities;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class URLDecode {
    
	
	public static String decodeURL(String encoded_string) throws UnsupportedEncodingException {
     
            
            String decodedString = URLDecoder.decode(encoded_string, "UTF-8");
            
           
           
            return URLDecoder.decode(decodedString, "UTF-8");
        
        
    }
}
