
package suhailmohd;


public class GenClusterHibernateState {

    public Long hibernateModeLogicalTimestamp;
    public String hibernateMode;
    public Boolean cancelHibernateTask;
    public Long hibernateTaskStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenClusterHibernateState() {
    }

    /**
     * 
     * @param cancelHibernateTask
     * @param hibernateTaskStatus
     * @param hibernateModeLogicalTimestamp
     * @param hibernateMode
     */
    public GenClusterHibernateState(Long hibernateModeLogicalTimestamp, String hibernateMode, Boolean cancelHibernateTask, Long hibernateTaskStatus) {
        super();
        this.hibernateModeLogicalTimestamp = hibernateModeLogicalTimestamp;
        this.hibernateMode = hibernateMode;
        this.cancelHibernateTask = cancelHibernateTask;
        this.hibernateTaskStatus = hibernateTaskStatus;
    }

}
