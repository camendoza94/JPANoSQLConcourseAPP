package co.edu.uniandes.isis2503.nosqljpa.auth;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;


public class CORSFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest crc, ContainerResponse crc1) {
        //TODO Edit to localhost:3000
        crc1.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        crc1.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        crc1.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        crc1.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization");
        return crc1;
    }
}