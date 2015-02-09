package net.pkhapps.fenix.core.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Base class for entities.
 */
@MappedSuperclass
public abstract class AbstractEntity extends AbstractPersistable<Long> {

    public static final String PROP_ID = "id";
    public static final String PROP_OPT_LOCK_VERSION = "optLockVersion";

    @Column(name = "rev", nullable = false)
    @Version
    private Long optLockVersion;

    protected AbstractEntity() {
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public Long getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Long optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (optLockVersion != null ? !optLockVersion.equals(that.optLockVersion) : that.optLockVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (optLockVersion != null ? optLockVersion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d, optLockVersion=%d, hash=%x]", getClass().getSimpleName(), getId(),
                getOptLockVersion(), System.identityHashCode(this));
    }
}
