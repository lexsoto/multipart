/*--
 ============================================================================
 Envieta PROPRIETARY
 ============================================================================
 This file and its contents are the intellectual property of Envieta.  It may
 not be used, copied, distributed or otherwise  disclosed in whole or in part
 without the express written permission of Envieta.
 ============================================================================
 Copyright (c) 2019, Envieta. All rights reserved.
 ============================================================================
*/
package multipart;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsName;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;


@Component(service = UploadJaxrs.class, scope = ServiceScope.PROTOTYPE)
@JaxrsResource
@Path("upload")
@JaxrsName("upload")
public class UploadJaxrs {

	@PUT
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void upload(@Context HttpServletRequest request) throws IOException, ServletException {
		Collection<Part> parts = request.getParts();

		for (Part part : parts) {
			System.out.printf("File name: %s, Type: %s, Size: %d/n", part.getName(),
					part.getContentType(),
					part.getSize());
		}
	}
}
