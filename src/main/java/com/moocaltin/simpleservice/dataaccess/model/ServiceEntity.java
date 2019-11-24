package com.moocaltin.simpleservice.dataaccess.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private Device device;
    @Length(max = 128)
    private String name;
    @Length(max = 128)
    private String producer;
    @Length(max = 128)
    private String model;
    @Length(max = 128)
    private String type;
    @Positive
    private Integer termDays;
    @Positive
    private Double cost;

    private String imageUrl;

    public ServiceEntity() {
    }

    public ServiceEntity(Long id,
                         Device device,
                         @Length(max = 128) String name,
                         @Length(max = 128) String producer,
                         @Length(max = 128) String model,
                         @Length(max = 128) String type,
                         @Positive Integer termDays,
                         @Positive Double cost,
                         String imageUrl) {
        this.id = id;
        this.device = device;
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.type = type;
        this.termDays = termDays;
        this.cost = cost;
        this.imageUrl = imageUrl;
    }

    public ServiceEntity(Device device,
                         @Length(max = 128) String name,
                         @Length(max = 128) String producer,
                         @Length(max = 128) String model,
                         @Length(max = 128) String type,
                         @Positive Integer termDays,
                         @Positive Double cost,
                         String imageUrl) {
        this.device = device;
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.type = type;
        this.termDays = termDays;
        this.cost = cost;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTermDays() {
        return termDays;
    }

    public void setTermDays(Integer termDays) {
        this.termDays = termDays;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ServiceEntity)) {
            return false;
        }

        ServiceEntity that = (ServiceEntity) o;

        if (!id.equals(that.id)) {
            return false;
        }
        if (device != that.device) {
            return false;
        }
        if (!name.equals(that.name)) {
            return false;
        }
        if (!producer.equals(that.producer)) {
            return false;
        }
        if (!model.equals(that.model)) {
            return false;
        }
        if (!type.equals(that.type)) {
            return false;
        }
        if (!termDays.equals(that.termDays)) {
            return false;
        }
        if (!cost.equals(that.cost)) {
            return false;
        }
        return imageUrl != null ? imageUrl.equals(that.imageUrl) : that.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + device.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + termDays.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
