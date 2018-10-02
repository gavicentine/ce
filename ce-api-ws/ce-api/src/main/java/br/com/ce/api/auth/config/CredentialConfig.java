package br.com.ce.api.auth.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class CredentialConfig.
 */
@Component
@ConfigurationProperties(prefix = "credential")
public class CredentialConfig
{
	
	/** The apps. */
	private Map<String, String> apps;

	/**
	 * Gets the apps.
	 *
	 * @return the apps
	 */
	public Map<String, String> getApps()
	{
		return apps;
	}

	/**
	 * Sets the apps.
	 *
	 * @param apps the apps
	 */
	public void setApps(Map<String, String> apps)
	{
		this.apps = apps;
	}

}
