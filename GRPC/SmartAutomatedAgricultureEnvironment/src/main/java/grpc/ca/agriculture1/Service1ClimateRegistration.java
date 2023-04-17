/*package grpc.ca.agriculture1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.util.Properties;
import com.sun.jersey.api.*;
import com.sun.jersey.api.client.Client;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Service1ClimateRegistration {
	private Properties getProperties() {
		
		Properties prop = null;
		
		try (InputStream input = new FileInputStream("src/main/resources/Service1.properties")){
			prop = new Properties();
			
			//load a properties file
			prop.load(input);
			
			//get the property value and print it out
			System.out.println("Service 1 Climate properties: ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));

		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
	private void registerService(Properties prop) {
		try {
			
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			String service_type = prop.getProperty("service_type");// "_http._tcp.local.";
			String service_name = prop.getProperty("service_name");// "service1";
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

			String service_description_properties = prop.getProperty("service_description");// "path=index.html";

			// Registration service information
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);

			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

			// Wait a bit for the service to register
			Thread.sleep(1000);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {

		Service1ClimateRegistration climateserviceserver = new Service1ClimateRegistration();
		
		Properties prop = climateserviceserver.getProperties();
		climateserviceserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port"));//#.50051;
		
		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(climateserviceserver).build().start();
			System.out.println("Server 1 for Climate Service is running...");
			server.awaitTermination();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}*/
