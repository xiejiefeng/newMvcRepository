package com.xjf.wemall.service.threadTest.threadLocalT;

//	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
//		public Connection initialValue() {
//    		return DriverManager.getConnection(DB_URL);
//		}
//	};
// 
//	public static Connection getConnection() {
//		return connectionHolder.get();
//	}

/*
	private static final ThreadLocal threadSession = new ThreadLocal();
 
	public static Session getSession() throws InfrastructureException {
    	Session s = (Session) threadSession.get();
    	try {
        	if (s == null) {
            	s = getSessionFactory().openSession();
            	threadSession.set(s);
        	}
    	} catch (HibernateException ex) {
        	throw new InfrastructureException(ex);
    	}
    	return s;
	}
 */
public class ThreadLocalInitialValue {
	    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
	        protected Long initialValue() {
	            return Thread.currentThread().getId();
	        };
	    };
	    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){;
	        protected String initialValue() {
	            return Thread.currentThread().getName();
	        };
	    };
	 
	     
	    public void set() {
	        longLocal.set(Thread.currentThread().getId());
	        stringLocal.set(Thread.currentThread().getName());
	    }
	     
	    public long getLong() {
	        return longLocal.get();
	    }
	     
	    public String getString() {
	        return stringLocal.get();
	    }
	     
	    public static void main(String[] args) throws InterruptedException {
	        final ThreadLocalInitialValue test = new ThreadLocalInitialValue();
	 
//	        test.set();
	        System.out.println(test.getLong());
	        System.out.println(test.getString());
	     
	         
	        Thread thread1 = new Thread(){
	            public void run() {
	                test.set();
	                System.out.println(test.getLong());
	                System.out.println(test.getString());
	            };
	        };
	        thread1.start();
	        thread1.join();
	         
	        System.out.println(test.getLong());
	        System.out.println(test.getString());
	    }
	}
