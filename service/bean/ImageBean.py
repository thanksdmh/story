
from sqlalchemy import Table, MetaData, Column, Integer, String, ForeignKey, DATETIME, create_engine
#
# CREATE TABLE `image` (
#   `sid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
#   `id` varchar(32) COLLATE utf8_bin NOT NULL,
#   `path` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   KEY `FK_Reference_2` (`sid`),
#   CONSTRAINT `FK_Reference_2` FOREIGN KEY (`sid`) REFERENCES `story` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='图片地址表';
# /*!40101 SET character_set_client = @saved_cs_client */;

image = Table('image', MetaData(),
               Column('id', String(32), primary_key=True),
               Column('sid', String(32)),
               Column('path', String(32))
               )


class Image(object):
    def __int__(self, id, sid, path):
        self.id = id
        self.sid = sid
        self.path = path
