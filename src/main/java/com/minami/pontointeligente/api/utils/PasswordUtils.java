package com.minami.pontointeligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

		private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
		
		public PasswordUtils() {
			
		}
		
		/* gera um hash utilizando o BCrypt
		 * @param senha
		 * @return String
		 */
		
		public static String gerarBCrypt(String senha) {
			if(senha == null) {
				return senha;
			}
			
			log.info("Gerando hasch com o BCrypt");
			BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
			return bCryptEncoder.encode(senha);
			
		}
}
