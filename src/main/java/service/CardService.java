package service;

import domain.dto.IssueDto;
import global.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class CardService {
    public void issue(IssueDto dto) {
        Connection conn;
        PreparedStatement ps = null;
        conn = DBUtil.getConnection();

        String[] userInfos = dto.getUser_Info().split(", ");
        boolean isWoori = dto.getIsWoori();
        Throwable occuredException = null;

        try {
            conn.setAutoCommit(false);

            String sql = "Insert Into user (user_name, phone, address, isWoori) values (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, userInfos[0]);
            ps.setString(2, userInfos[1]);
            ps.setString(3, userInfos[2]);
            ps.setInt(4, isWoori ? 1 : 0);

            ps.execute();

            sql = "INSERT INTO  card (cardId, company, balance) values (?, ?, ?)";
            ps = conn.prepareStatement(sql);

            UUID uuid = UUID.randomUUID();
            ps.setString(1, uuid.toString());
            ps.setString(2, userInfos[3]);
            ps.setInt(3, 0);

            ps.execute();
            conn.commit();
        } catch (Throwable e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                }
            }
            occuredException = e;
        } finally {
            if (ps != null)
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
            }
        }
    }

}
