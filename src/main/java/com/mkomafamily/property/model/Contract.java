package com.mkomafamily.property.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contracts")
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate enDateTime;

    @Column(name = "payment_terms", length = 255)
    private String paymentTerms;

    @Column(name = "contract_status", nullable = false)
    private String contractStatus;

    @Column(name = "additional_terms", columnDefinition = "TEXT")
    private String additionalTerms;

    public Contract(Tenant tenant, Property property, LocalDate startDate, LocalDate enDateTime, String paymentTerms,
            String contractStatus, String additionalTerms) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.enDateTime = enDateTime;
        this.paymentTerms = paymentTerms;
        this.contractStatus = contractStatus;
        this.additionalTerms = additionalTerms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEnDateTime() {
        return enDateTime;
    }

    public void setEnDateTime(LocalDate enDateTime) {
        this.enDateTime = enDateTime;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getAdditionalTerms() {
        return additionalTerms;
    }

    public void setAdditionalTerms(String additionalTerms) {
        this.additionalTerms = additionalTerms;
    }

}
