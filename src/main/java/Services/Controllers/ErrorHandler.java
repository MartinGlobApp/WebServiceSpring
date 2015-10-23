package Services.Controllers;

import Data.MyResponse;
import Data.ResponseStates;
import Services.Common.MyModel;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by martin-valdez on 23/10/15.
 */
@Controller
@RequestMapping("/errors")
public class ErrorHandler implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer factory) {
        factory.setPort(9000);
        factory.addErrorPages(new ErrorPage("/errors/unexpected"));
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/errors/notfound"));
    }

    @RequestMapping("unexpected")
    @ResponseBody
    public MyResponse unexpectedError(final HttpServletRequest request)
    {
        MyResponse response = new MyResponse();
        response.setCode(987);
        response.setData("Exception: " + request.getAttribute("javax.servlet.error.exception"));
        return response;
    }

    @RequestMapping("notfound")
    @ResponseBody
    public MyResponse notFound()
    {
        MyResponse response = new MyResponse();
        response.setCode(ResponseStates.ERROR_NOT_FOUND);
        return response;
    }
}
