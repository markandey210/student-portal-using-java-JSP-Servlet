package connectivity;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class NamedParameterStatement {
	private final PreparedStatement statement;
	private final Map<String, Set<Integer>> indexMap;
	public NamedParameterStatement(Connection con, String query) throws SQLException {
		indexMap = new HashMap<String, Set<Integer>>();
		String parsedQuery = parse(query);
		statement = con.prepareStatement(parsedQuery);
	}

	public NamedParameterStatement(Connection connection, String query, boolean returnGeneratedKey)
			throws SQLException {
		indexMap = new HashMap<String, Set<Integer>>();
		String parsedQuery = parse(query);
		statement = connection.prepareStatement(parsedQuery, Statement.RETURN_GENERATED_KEYS);
	}

	private String parse(String query) {
		int length = query.length();
		StringBuffer parsedQuery = new StringBuffer(length);
		boolean inSingleQuote = false;
		boolean inDoubleQuote = false;
		int index = 1;

		for (int i = 0; i < length; i++) {
			char c = query.charAt(i);
			if (inSingleQuote) {
				if (c == '\'') {
					inSingleQuote = false;
				}
			} else if (inDoubleQuote) {
				if (c == '"') {
					inDoubleQuote = false;
				}
			} else {
				if (c == '\'') {
					inSingleQuote = true;
				} else if (c == '"') {
					inDoubleQuote = true;
				} else if (c == ':' && i + 1 < length && Character.isJavaIdentifierStart(query.charAt(i + 1))) {
					int j = i + 2;
					while (j < length && Character.isJavaIdentifierPart(query.charAt(j))) {
						j++;
					}
					String name = query.substring(i + 1, j);
					c = '?'; 
					i += name.length();

					Set<Integer> indexSet = indexMap.get(name);
					if (indexSet == null) {
						indexSet = new HashSet<Integer>();
						indexMap.put(name, indexSet);
					}
					indexSet.add(index);
					index++;
				}
			}
			parsedQuery.append(c);
		}

		return parsedQuery.toString();
	}

	
	private Set<Integer> getIndexes(String name) {
		Set<Integer> indexes = indexMap.get(name);
		if (indexes == null) {
			throw new IllegalArgumentException("Parameter not found: " + name);
		}
		return indexes;
	}

	public void setObject(String name, Object value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setObject(itr.next(), value);
		}
	}

	public void setString(String name, String value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setString(itr.next(), value);
		}
	}

	
	public void setBoolean(String name, boolean value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setBoolean(itr.next(), value);
		}
	}

	public void setInt(String name, int value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setInt(itr.next(), value);
		}
	}

	public void setLong(String name, long value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setLong(itr.next(), value);
		}
	}

	
	public void setDouble(String name, Double value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setDouble(itr.next(), value);
		}
	}

	public void setFloat(String name, Float value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setFloat(itr.next(), value);
		}
	}

	
	public void setBlob(String name, Blob value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setBlob(itr.next(), value);
		}
	}

	public void setTimestamp(String name, Timestamp value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setTimestamp(itr.next(), value);
		}
	}

	
	public void setDate(String name, Date value) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setDate(itr.next(), value);
		}
	}

	public void setNull(String name) throws SQLException {
		Set<Integer> indexes = getIndexes(name);
		for (Iterator<Integer> itr = indexes.iterator(); itr.hasNext();) {
			statement.setNull(itr.next(), 0);
		}
	}

	public PreparedStatement getStatement() {
		return statement;
	}

	public boolean execute() throws SQLException {
		return statement.execute();
	}

	public ResultSet executeQuery() throws SQLException {
		return statement.executeQuery();
	}

	public int executeUpdate() throws SQLException {
		return statement.executeUpdate();
	}

	public void close() throws SQLException {
		statement.close();
	}

	public void addBatch() throws SQLException {
		statement.addBatch();
	}

	public int[] executeBatch() throws SQLException {
		return statement.executeBatch();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return statement.getGeneratedKeys();
	}
}

