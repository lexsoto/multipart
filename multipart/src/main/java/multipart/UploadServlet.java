package multipart;


import java.io.IOException;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@WebServlet(value = "/multipart", name = "multipart")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 100 // 100MB
)
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			System.out.printf("File %s, %s, %d%n", part.getName(),
					part.getContentType(), part.getSize());
		}
	}

}
