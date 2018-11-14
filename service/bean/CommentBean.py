from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine

# CREATE TABLE `comment` (
#   `cid` varbinary(32) NOT NULL,
#   `sid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `detail` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
#   `time` datetime DEFAULT NULL,
#   PRIMARY KEY (`cid`),
#   KEY `FK_Reference_3` (`sid`),
#   KEY `FK_Reference_4` (`uid`),
#   CONSTRAINT `FK_Reference_3` FOREIGN KEY (`sid`) REFERENCES `story` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
#   CONSTRAINT `FK_Reference_4` FOREIGN KEY (`uid`) REFERENCES `author` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='评论表';
# /*!40101 SET character_set_client = @saved_cs_client */;
comment = Table('comment', MetaData(),
             Column('cid', String(32), primary_key=True),
             Column('sid', String(32)),
             Column('uid', String(32)),
             Column('detail', String(1000)),
             Column('time', DATETIME)
             )


class Comment(object):
    def __int__(self,cid, sid, uid, detail, time):
        self.sid = sid
        self.uid = uid
        self.detail = detail
        self.time = time