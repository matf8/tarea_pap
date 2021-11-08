package persistencia;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nickName;
	private String mail;
	
	public UsuarioId() {
		super();
	}
			
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(mail, nickName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioId other = (UsuarioId) obj;
		return Objects.equals(mail, other.mail) && Objects.equals(nickName, other.nickName);
	}		
}
