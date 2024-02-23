/* COMPSCI 424 Program 1
 * Name:
 */
package compsci424.p1.java;

/**
 * The process control block structure that is used to track a
 * process's parent and children (if any) in Version 1.
 */
public class Version1PCB {
	 private int pid;
	    private Version1PCB parent;
	    private List<Version1PCB> children;

	    // Constructor
	    public Version1PCB(int pid, Version1PCB parent) {
	        this.pid = pid;
	        this.parent = parent;
	        this.children = new ArrayList<>();
	    }
	    public int getPid() {
	        return pid;
	    }

	    public void setPid(int pid) {
	        this.pid = pid;
	    }

	    public Version1PCB getParent() {
	        return parent;
	    }

	    public void setParent(Version1PCB parent) {
	        this.parent = parent;
	    }

	    public List<Version1PCB> getChildren() {
	        return children;
	    }

	    public void setChildren(List<Version1PCB> children) {
	        this.children = children;
	    }

	    // Method to add a child PCB
	    public void addChild(Version1PCB child) {
	        children.add(child);
	    }

	    // Method to remove a child PCB
	    public void removeChild(Version1PCB child) {
	        children.remove(child);
	    }
	    public Version1PCB findPCB(int pid) {//findPCB method
	        for (Version1PCB pcb : children) {
	            if (pcb.getPid() == pid) {
	                return pcb;
	            }
	        }
	        return null; // returns null if PCB with correct PID isnt found
	    }
	    
	    
	    
}//End Version1PCB
