package DBProxy.Plugin.example;

/*
 * Example plugin. Return a fake result set for every query
 */

import DBProxy.Core.Engine;
import DBProxy.MySQL.Protocol.Column;
import DBProxy.MySQL.Protocol.Flags;
import DBProxy.MySQL.Protocol.ResultSet;
import DBProxy.MySQL.Protocol.Row;
import org.apache.log4j.Logger;
import DBProxy.Plugin.Base;


public class ResultSetExample extends Base {

    public void init(Engine context) {
        this.logger = Logger.getLogger("Plugin.Example.ResultSetExample");
    }
    
    public void read_query(Engine context) {
        this.logger.info("Plugin->read_query");
        
        ResultSet rs = new ResultSet();
        
        Column col = new Column("Fake Data");
        rs.addColumn(col);
        
        rs.addRow(new Row("1")); 
        
        context.clear_buffer();
        context.buffer = rs.toPackets();
        context.nextMode = Flags.MODE_SEND_QUERY_RESULT;
    }
}
