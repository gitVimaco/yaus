package yaus

class Link {
    String url
    Date dateCreated
    String ip
    static hasMany = [visits: Visit]

    static constraints = {
        url url: true
        ip nullable: true
    }
}
