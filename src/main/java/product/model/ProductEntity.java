package product.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import user.model.UserEntity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "barcode")
    private long barcode;

    @Column(name = "image", columnDefinition = "TEXT[]")
    private String[] image;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private String ownerId;

    @Column(name="producer")
    private String producer;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "avg_rating")
    private int avgRating;

    @Column(name = "version")
    private String version;

    @Column(name = "price")
    private float price;

    @Column(name = "species")
    private String species;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "_upload_date")
    private Date uploadDate;

    @Column(name = "_is_delete")
    private boolean isDelete = false;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String ... image) {
        this.image = image;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode=" + barcode +
                ", image=" + Arrays.toString(image) +
                ", ownerId='" + ownerId + '\'' +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", avgRating=" + avgRating +
                ", version='" + version + '\'' +
                ", price=" + price +
                ", species='" + species + '\'' +
                ", uploadDate=" + uploadDate +
                ", isDelete=" + isDelete +
                '}';
    }
}
