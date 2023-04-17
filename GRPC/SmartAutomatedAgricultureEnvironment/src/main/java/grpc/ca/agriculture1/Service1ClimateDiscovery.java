/*package grpc.ca.agriculture1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public class Service1ClimateDiscovery {
	private static class Service1Listener implements ServiceListener {

		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println(" Service added : " + event.getInfo());
		}

		@Override
		public void serviceRemoved ( ServiceEvent event ) {
			System . out . println (" Service removed : " + event . getInfo ());
		}

		@Override
		public void serviceResolved ( ServiceEvent event ) {
			System . out . println (" Service resolved : " + event . getInfo()) ;
		}
	}

	public static void main ( String [] args ) throws InterruptedException {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS . create ( InetAddress . getLocalHost () ) ;
			// Add a service listener
			jmdns . addServiceListener (" _service1_tcp.local." , new Service1Listener () ) ;
		} catch ( UnknownHostException e ) {
			System . out . println (e . getMessage () ) ;
		} catch ( IOException e ) {
			System . out . println (e . getMessage () ) ;
		}
	}
}*/