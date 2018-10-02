package br.com.ce.api.auth.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.SigningKeyResolverAdapter;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SecretKey objects.
 */
@Service
public class SecretKeyFactory
{

	/** The secrets. */
	private Map<String, String> secrets = new HashMap<>();

	/** The signing key resolver. */
	private SigningKeyResolver signingKeyResolver = new SigningKeyResolverAdapter()
	{
		@SuppressWarnings("rawtypes")
		@Override
		public byte[] resolveSigningKeyBytes(JwsHeader header, Claims claims)
		{
			return TextCodec.BASE64.decode(secrets.get(header.getAlgorithm()));
		}
	};

	/**
	 * Setup.
	 */
	@PostConstruct
	public void setup()
	{
		refreshSecrets();
	}

	/**
	 * Gets the signing key resolver.
	 *
	 * @return the signing key resolver
	 */
	public SigningKeyResolver getSigningKeyResolver()
	{
		return signingKeyResolver;
	}

	/**
	 * Gets the HS 256 secret bytes.
	 *
	 * @return the HS 256 secret bytes
	 */
	public byte[] getHS256SecretBytes()
	{
		return TextCodec.BASE64.decode(secrets.get(SignatureAlgorithm.HS256.getValue()));
	}

	/**
	 * Gets the HS 384 secret bytes.
	 *
	 * @return the HS 384 secret bytes
	 */
	public byte[] getHS384SecretBytes()
	{
		return TextCodec.BASE64.decode(secrets.get(SignatureAlgorithm.HS384.getValue()));
	}

	/**
	 * Gets the HS 512 secret bytes.
	 *
	 * @return the HS 512 secret bytes
	 */
	public byte[] getHS512SecretBytes()
	{
		return TextCodec.BASE64.decode(secrets.get(SignatureAlgorithm.HS512.getValue()));
	}

	/**
	 * Refresh secrets.
	 *
	 * @return the map
	 */
	public Map<String, String> refreshSecrets()
	{
		SecretKey key = MacProvider.generateKey(SignatureAlgorithm.HS256);
		secrets.put(SignatureAlgorithm.HS256.getValue(), TextCodec.BASE64.encode(key.getEncoded()));
		
		key = MacProvider.generateKey(SignatureAlgorithm.HS384);
		secrets.put(SignatureAlgorithm.HS384.getValue(), TextCodec.BASE64.encode(key.getEncoded()));

		key = MacProvider.generateKey(SignatureAlgorithm.HS512);
		secrets.put(SignatureAlgorithm.HS512.getValue(), TextCodec.BASE64.encode(key.getEncoded()));
		return secrets;
	}
}
