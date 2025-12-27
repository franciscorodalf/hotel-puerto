package org.docencia.hotel.domain.model;

public class Guest {

    Long id;
    String name;
    String lastName;
    String email;
    String phone;

    /**
     * Constructor vacio
     */
    public Guest() {

    }

    /**
     * Constructor con id
     * 
     * @param id del guest
     */
    public Guest(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros
     * 
     * @param id       del guest
     * @param name     del guest
     * @param lastName del guest
     * @param email    del guest
     * @param phone    del guest
     */
    public Guest(Long id, String name, String lastName, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    /**
     * GETTERS AND SETTERS
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Guest [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Guest other = (Guest) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
