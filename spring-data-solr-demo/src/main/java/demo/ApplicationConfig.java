/**
 * 
 */
package demo;

import java.io.File;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.util.ResourceUtils;

/**
 * @author Siva
 *
 */
@Configuration
@EnableSolrRepositories
class ApplicationConfig
{

	@Bean
	public SolrServer solrServer() throws Exception
	{
		String solrHome = ResourceUtils.getURL("classpath:demo/solr").getPath();
	    CoreContainer container = CoreContainer.createAndLoad(solrHome, new File(solrHome + "/solr.xml"));

	    return new EmbeddedSolrServer(container, "core1");
	}

	@Bean
	public SolrOperations solrTemplate() throws Exception
	{
		return new SolrTemplate(solrServer());
	}
	 
}
