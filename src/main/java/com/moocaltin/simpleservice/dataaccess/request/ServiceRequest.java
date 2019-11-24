package com.moocaltin.simpleservice.dataaccess.request;

import com.moocaltin.simpleservice.dataaccess.model.Device;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ServiceRequest {

    @NotNull
    private Device device;

    @NotNull
    @Length(max = 128)
    private String name;

    @NotNull
    @Length(max = 128)
    private String producer;

    @NotNull
    @Length(max = 128)
    private String model;

    @NotNull
    @Length(max = 128)
    private String type;

    @NotNull
    @Positive
    private Integer termDays;

    @NotNull
    @Positive
    private Double cost;

    @Nullable
    @Length(max = 1024)
    private String imageUrl;

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

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@Nullable String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ServiceRequest)) {
            return false;
        }

        ServiceRequest that = (ServiceRequest) o;

        if (device != that.device) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (producer != null ? !producer.equals(that.producer) : that.producer != null) {
            return false;
        }
        if (model != null ? !model.equals(that.model) : that.model != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }
        if (termDays != null ? !termDays.equals(that.termDays) : that.termDays != null) {
            return false;
        }
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) {
            return false;
        }
        return imageUrl != null ? imageUrl.equals(that.imageUrl) : that.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = device != null ? device.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (termDays != null ? termDays.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
