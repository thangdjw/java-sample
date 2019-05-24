package product.model;

public class ProductFilter {
    private String filter_name;
    private float filter_lt_price;
    private float filter_gt_price;
    private String filter_owner;
    private String filter_producer;
    private String filter_species;
    private boolean sort_name;
    private boolean sort_price;

    public String getFilter_name() {
        return filter_name;
    }

    public void setFilter_name(String filter_name) {
        this.filter_name = filter_name;
    }

    public float getFilter_lt_price() {
        return filter_lt_price;
    }

    public void setFilter_lt_price(float filter_lt_price) {
        this.filter_lt_price = filter_lt_price;
    }

    public String getFilter_owner() {
        return filter_owner;
    }

    public void setFilter_owner(String filter_owner) {
        this.filter_owner = filter_owner;
    }

    public String getFilter_producer() {
        return filter_producer;
    }

    public void setFilter_producer(String filter_producer) {
        this.filter_producer = filter_producer;
    }

    public String getFilter_species() {
        return filter_species;
    }

    public void setFilter_species(String filter_species) {
        this.filter_species = filter_species;
    }

    public boolean getSort_name() {
        return sort_name;
    }

    public void setSort_name(boolean sort_name) {
        this.sort_name = sort_name;
    }

    public boolean getSort_price() {
        return sort_price;
    }

    public void setSort_price(boolean sort_price) {
        this.sort_price = sort_price;
    }

    public float getFilter_gt_price() {
        return filter_gt_price;
    }

    public void setFilter_gt_price(float filter_gt_price) {
        this.filter_gt_price = filter_gt_price;
    }
}
