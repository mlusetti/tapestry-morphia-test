package it.datacode.tests.mongodb;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import org.apache.tapestry5.beaneditor.NonVisual;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: massimo
 * Date: 8/2/12
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class ElementiSezioneAreaPrivata
{
    private static final long serialVersionUID = 1L;

    @NonVisual @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String filename;
    private String filesize;
    private String filetype;
    @Indexed(unique = true)
    private String codice;
    private String descrizione;
    private String versione;
    @Indexed
    private String prodotto;
    private BigDecimal prezzo;
    private Date creato = new Date();
    private Date modificato = new Date();
    private boolean disabled = false;
    private SottoMenuAreaPrivata sezione;
    private Utente utente;

    @Override
    public int compareTo(ElementiSezioneAreaPrivata o)
    {
        int res = modificato.compareTo(o.getModificato());

        if (res != 0) return res;

        res = creato.compareTo(o.getCreato());

        if (res != 0) return res;

        return filename.compareTo(o.getFilename());
    }

    @Override
    public String toString() {
        return "ElementiSezioneAreaPrivata{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
