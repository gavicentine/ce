/* 
 * D2S Solucoes em TI
 * Copyright (c) 2015, All rights reserved. 
 */
package br.com.ce.common.base.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

// TODO: Auto-generated Javadoc

/**
 * The Class CryptUtil.
 */
public class CryptUtil
{

	/** The Constant STR_UTF8. */
	private static final String STR_UTF8 = "UTF8";

	/** The Constant STR_KEY. */
	private static final String STR_KEY = "ezweb2015@mz1y34";

	/** The Constant STR_AES. */
	private static final String STR_AES = "AES";

	/** The ecipher. */
	private static Cipher ecipher;

	/** The dcipher. */
	private static Cipher dcipher;

	/**
	 * Instantiates a new crypt util.
	 */
	public CryptUtil()
	{
		try
		{

			ecipher = Cipher.getInstance(STR_AES);
			dcipher = Cipher.getInstance(STR_AES);

			Key key = new SecretKeySpec(STR_KEY.getBytes(), STR_AES);

			ecipher.init(Cipher.ENCRYPT_MODE, key);
			dcipher.init(Cipher.DECRYPT_MODE, key);

		}
		catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvalidKeyException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Encrypt.
	 *
	 * @param str the str
	 * @return the string
	 */
	public String encrypt(String str)
	{
		try
		{
			// Encode the string into bytes using utf-8
			byte[] utf8 = str.getBytes(STR_UTF8);

			// Encrypt
			byte[] enc = ecipher.doFinal(utf8);

			// Encode bytes to base64 to get a string
			// return new sun.misc.BASE64Encoder().encode(enc);

			return DatatypeConverter.printBase64Binary(enc);

			// String base64String = DatatypeConverter.printBase64Binary(baos.toByteArray());
			// byte[] bytearray = DatatypeConverter.parseBase64Binary(base64String);
		}
		catch (javax.crypto.BadPaddingException e)
		{
		}
		catch (IllegalBlockSizeException e)
		{
		}
		catch (UnsupportedEncodingException e)
		{
		}

		return null;
	}

	/**
	 * Decrypt.
	 *
	 * @param str the str
	 * @return the string
	 */
	public String decrypt(String str)
	{
		try
		{
			// Decode base64 to get bytes
			// byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

			byte[] dec = DatatypeConverter.parseBase64Binary(str);

			// Decrypt
			byte[] utf8 = dcipher.doFinal(dec);

			// Decode using utf-8
			return new String(utf8, STR_UTF8);
		}
		catch (javax.crypto.BadPaddingException e)
		{
		}
		catch (IllegalBlockSizeException e)
		{
		}
		catch (UnsupportedEncodingException e)
		{
		}
		return null;
	}

}
