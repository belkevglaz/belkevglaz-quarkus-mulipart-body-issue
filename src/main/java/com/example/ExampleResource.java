package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.InputStream;

@Path("/hello")
public class ExampleResource {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(@MultipartForm MultipartBody body) {
		System.out.println("Got the file in multipart body.");
		return Response.ok().build();
	}

	@Data
	@Builder
	public static class MultipartBody {
		@FormParam("stream")
		@PartType(MediaType.APPLICATION_OCTET_STREAM)
		private File stream;
	}

}