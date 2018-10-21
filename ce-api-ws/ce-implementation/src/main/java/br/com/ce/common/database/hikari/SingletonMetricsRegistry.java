package br.com.ce.common.database.hikari;


import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

// TODO: Auto-generated Javadoc
/**
 * The Class SingletonMetricsRegistry.
 */
public class SingletonMetricsRegistry
{
  
  /** The Constant instance. */
  private static final SingletonMetricsRegistry instance = new SingletonMetricsRegistry();
  
  /** The registry. */
  private MetricRegistry registry = null;
  
  /** The reporter. */
  private JmxReporter reporter = null;
  
  /**
   * Gets the single instance of SingletonMetricsRegistry.
   *
   * @return single instance of SingletonMetricsRegistry
   */
  public static SingletonMetricsRegistry getInstance()
  {
    return instance;
  }
  
  /**
   * Gets the registry.
   *
   * @return the registry
   */
  public synchronized MetricRegistry getRegistry()
  {
    if (this.registry == null)
    {
      this.registry = new MetricRegistry();
      this.reporter = JmxReporter.forRegistry(this.registry).inDomain("com.ezproc.hikariCP").build();
      this.reporter.start();
    }
    return this.registry;
  }
  
  /**
   * Destroy.
   */
  public synchronized void destroy()
  {
    if (this.reporter != null)
    {
      this.reporter.stop();
      this.reporter.close();
      this.registry = null;
      this.reporter = null;
    }
  }
}
