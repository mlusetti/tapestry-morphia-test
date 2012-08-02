package it.datacode.tests.mongodb;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Transient;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity("utenti")
public class Utente
{
        private static final long serialVersionUID = 1L;


        @Id
        private ObjectId id;
        @Indexed(unique = true)
        private String userName;
        @Indexed
        private String nome;

        private boolean admin;

        private boolean marketingAdmin;

        private boolean technicalAdmin;

        private String descrizione;

        @Indexed(unique = true)
        private String email;

        private String encodedPassword;

        private Date created = new Date();

        private boolean accountLocked;

        private boolean credentialsExpired;

        private byte[] passwordSalt;

        @Transient
        private String password;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utente")
        private Set<ElementiSezioneAreaPrivata> elementi = new HashSet<ElementiSezioneAreaPrivata>();


        public String getPassword()
        {
            return "";
        }

        public void setPassword(String password)
        {
            if (password != null && !password.equals(encodedPassword) && !"".equals(password))
            {
//                ByteSource saltSource = new SecureRandomNumberGenerator().nextBytes();
//                this.passwordSalt = saltSource.getBytes();
//                this.encodedPassword = new Sha1Hash(password, saltSource).toString();
            }
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Utente utente = (Utente) o;

            if (userName != null ? !userName.equals(utente.userName) : utente.userName!= null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = userName != null ? userName.hashCode() : 0;
            return result;
        }

        @Override
        public String toString()
        {
            return "Utente{" +
                    "nome='" + nome + '\'' + '}';
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public boolean isAccountLocked() {
            return accountLocked;
        }

        public void setAccountLocked(boolean accountLocked) {
            this.accountLocked = accountLocked;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }

        public boolean isCredentialsExpired() {
            return credentialsExpired;
        }

        public void setCredentialsExpired(boolean credentialsExpired) {
            this.credentialsExpired = credentialsExpired;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEncodedPassword() {
            return encodedPassword;
        }

        public void setEncodedPassword(String encodedPassword) {
            this.encodedPassword = encodedPassword;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public byte[] getPasswordSalt() {
            return passwordSalt;
        }

        public void setPasswordSalt(byte[] passwordSalt) {
            this.passwordSalt = passwordSalt;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public boolean isMarketingAdmin() {
            return marketingAdmin;
        }

        public void setMarketingAdmin(boolean marketingAdmin) {
            this.marketingAdmin = marketingAdmin;
        }

        public boolean isTechnicalAdmin() {
            return technicalAdmin;
        }

        public void setTechnicalAdmin(boolean technicalAdmin) {
            this.technicalAdmin = technicalAdmin;
        }

        public Set<ElementiSezioneAreaPrivata> getElementi() {
            return elementi;
        }

        public void setElementi(Set<ElementiSezioneAreaPrivata> elementi) {
            this.elementi = elementi;
        }
}
