from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine

# CREATE TABLE `frend_ship` (
#   `fid` varchar(32) COLLATE utf8_bin NOT NULL,
#   `uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `fuid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   PRIMARY KEY (`fid`),
#   KEY `FK_Reference_5` (`uid`),
#   KEY `FK_Reference_6` (`fuid`),
#   CONSTRAINT `FK_Reference_5` FOREIGN KEY (`uid`) REFERENCES `name` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
#   CONSTRAINT `FK_Reference_6` FOREIGN KEY (`fuid`) REFERENCES `name` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='好友关系表';
# /*!40101 SET character_set_client = @saved_cs_client */;

friend = Table('frend_ship', MetaData(),
               Column('fid', String(32), primary_key=True),
               Column('uid', String(32)),
               Column('fuid', String(32))
               )


class FriendShip(object):
    def __int__(self, fid, uid, fuid):
        self.fid = fid
        self.uid = uid
        self.fuid = fuid
