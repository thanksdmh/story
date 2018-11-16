

#  SET character_set_client = utf8mb4 ;
# CREATE TABLE `love_record` (
#   `lid` varchar(32) COLLATE utf8_bin NOT NULL,
#   `sid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `uid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `time` datetime DEFAULT NULL,
#   PRIMARY KEY (`lid`),
#   KEY `FK_Reference_10` (`uid`),
#   KEY `FK_Reference_9` (`sid`),
#   CONSTRAINT `FK_Reference_10` FOREIGN KEY (`uid`) REFERENCES `author` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
#   CONSTRAINT `FK_Reference_9` FOREIGN KEY (`sid`) REFERENCES `story` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

from sqlalchemy import Table, MetaData, Column, String, DATETIME

love_record = Table('love_record', MetaData(),
               Column('lid', String(32), primary_key=True),
               Column('sid', String(32)),
               Column('uid', String(32)),
               Column('time', DATETIME)
               )


class LoveRecord(object):
    def __int__(self, lid, sid,uid, time):
        self.lid = lid
        self.sid = sid
        self.uid = uid
        self.time = time