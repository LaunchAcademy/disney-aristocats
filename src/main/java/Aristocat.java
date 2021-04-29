import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="aristocats")
public class Aristocat {
  @Id
  @SequenceGenerator(name="aristocat_generator", sequenceName = "aristocats_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="aristocat_generator")
  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotEmpty
  @Column(name="first_name", nullable=false)
  private String firstName;

  @NotEmpty
  @Column(name="last_name", nullable=false)
  private String lastName;

  @NotNull
  @URL
  @Column(name="photo_url", nullable=false)
  private String photoUrl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }
}