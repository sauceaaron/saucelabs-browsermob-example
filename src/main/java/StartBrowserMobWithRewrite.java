import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;

import java.util.Scanner;

public class StartBrowserMobWithRewrite
{
	public static void main(String[] args)
	{
		System.out.println("starting browsermob proxy");
		BrowserMobProxy proxy = new BrowserMobProxyServer();
//		proxy.setTrustAllServers(true);
//		proxy.rewriteUrl("http://dev.lightning.(.*$)", "http://$1");

		proxy.addRequestFilter(new RequestFilter()
		{
			@Override
			public HttpResponse filterRequest(HttpRequest request, HttpMessageContents message, HttpMessageInfo info)
			{
				System.out.println("Original request URL: " + request.getUri());
				request.setUri(request.getUri().replaceAll("foo", "bar"));
				request.setUri(request.getUri().replace("dev.lightning.", ""));
				System.out.println("Changed request URL: " + request.getUri());

				return null;
			}
		});

		proxy.start(55555);

		int port = proxy.getPort();
		System.out.println("started proxy server on " + " http://localhost:" + port);

		while(true)
		{
			try { Thread.sleep(10000); System.out.println(".");}
			catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
