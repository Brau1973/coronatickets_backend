package configuraciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class WebServiceConfiguracion {
	private String path = System.getProperty("user.home") + "/.CoronaTickets/.properties";
    private HashMap<String, String> configs;
    
    public WebServiceConfiguracion() throws Exception {
        configs = new HashMap<>();
        System.out.println(path);
        @SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(path));
        String properties;
        try {
            while((properties = reader.readLine()) != null){
                if(properties.startsWith("#")) {
                    String[] div = properties.split("=");
                    configs.put(div[0], div[1]);
                }
            }
        } catch(Exception e) {
            //throw new ErrorEnFileException();
        }
    }
    
    public String getConfigOf(String nombre) {
        return configs.get(nombre); 
    }
}