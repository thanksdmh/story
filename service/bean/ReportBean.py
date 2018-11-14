# CREATE TABLE `report` (
#   `rid` varchar(32) COLLATE utf8_bin NOT NULL,
#   `sid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `time` datetime DEFAULT NULL,
#   `reson` varchar(200) COLLATE utf8_bin DEFAULT NULL,
#   PRIMARY KEY (`rid`),
#   KEY `FK_Reference_7` (`sid`),
#   KEY `FK_Reference_8` (`uid`),
#   CONSTRAINT `FK_Reference_7` FOREIGN KEY (`sid`) REFERENCES `story` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
#   CONSTRAINT `FK_Reference_8` FOREIGN KEY (`uid`) REFERENCES `author` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='举报记录表';

from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine

report = Table('report', MetaData(),
               Column('rid', String(32), primary_key=True),
               Column('sid', String(32)),
               Column('uid', String(32)),
               Column('time', DATETIME),
               Column('reson', DATETIME)
               )


class report(object):
    def __int__(self, rid, sid, uid, time, reson):
        self.rid = rid
        self.sid = sid
        self.uid = uid
        self.time = time
        self.reson = reson
